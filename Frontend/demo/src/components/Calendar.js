import React, { useState } from 'react';
import './Calendar.css';

const Calendar = () => {
  const [events, setEvents] = useState([]);
  const [isAddingEvent, setIsAddingEvent] = useState(false);
  const [newEventDate, setNewEventDate] = useState("");
  const [newEventTitle, setNewEventTitle] = useState("");
  const [selectedDate, setSelectedDate] = useState(null);

  const daysInMonth = (month, year) => new Date(year, month + 1, 0).getDate();

  const renderCalendar = () => {
    const year = new Date().getFullYear();
    const month = new Date().getMonth();
    const days = daysInMonth(month, year);
    const startDay = new Date(year, month, 1).getDay();

    const cells = [];
    for (let i = 0; i < startDay; i++) {
      cells.push(<div key={`empty-${i}`} className="calendar-cell"></div>);
    }
    for (let i = 1; i <= days; i++) {
      const cellDate = `${year}-${month + 1}-${i}`;
      const isEvent = events.find(event => event.date === cellDate);
      cells.push(
        <div
          key={i}
          className={`calendar-cell ${isEvent ? 'event' : ''}`}
          onClick={() => handleCellClick(cellDate)}
        >
          {i}
        </div>
      );
    }
    return cells;
  };

  const handleCellClick = (date) => {
    const event = events.find(event => event.date === date);
    if (event) {
      setSelectedDate(event);
    } else {
      setNewEventDate(date);
      setIsAddingEvent(true);
    }
  };

  const addEvent = () => {
    if (newEventTitle.trim() !== "") {
      setEvents([...events, { date: newEventDate, title: newEventTitle }]);
      setNewEventTitle("");
      setIsAddingEvent(false);
    }
  };

  return (
    <div className="calendar-container">
      <h1>일정 관리</h1>
      <div className="calendar">
        <div className="calendar-header">
          <button>이전</button>
          <div>2024년 6월</div>
          <button>다음</button>
        </div>
        <div className="calendar-grid">
          {renderCalendar()}
        </div>
      </div>
      {isAddingEvent && (
        <div className="popup">
          <div className="popup-inner">
            <h2>일정 추가</h2>
            <input
              type="text"
              placeholder="일정 제목"
              value={newEventTitle}
              onChange={(e) => setNewEventTitle(e.target.value)}
            />
            <div className="popup-buttons">
              <button className="styled-button" onClick={addEvent}>
                추가
              </button>
              <button
                className="styled-button"
                onClick={() => setIsAddingEvent(false)}
              >
                취소
              </button>
            </div>
          </div>
        </div>
      )}
      {selectedDate && (
        <div className="popup">
          <div className="popup-inner">
            <h2>일정 확인</h2>
            <p>{selectedDate.title}</p>
            <div className="popup-buttons">
              <button
                className="styled-button"
                onClick={() => setSelectedDate(null)}
              >
                닫기
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default Calendar;
