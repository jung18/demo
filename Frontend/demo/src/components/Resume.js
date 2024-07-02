import React, { useState } from 'react';
import './Resume.css';

const Resume = () => {
  const [resumes, setResumes] = useState([{ id: 1, name: "자소서 1", questions: [] }]);
  const [newQuestion, setNewQuestion] = useState("");
  const [currentResumeId, setCurrentResumeId] = useState(1);
  const [isAddingResume, setIsAddingResume] = useState(false);
  const [newResumeName, setNewResumeName] = useState("");

  const addQuestion = () => {
    if (newQuestion.trim() !== "") {
      setResumes(resumes.map(r => 
        r.id === currentResumeId 
          ? { ...r, questions: [...r.questions, { question: newQuestion, answer: "", isEditing: false, isOpen: false }] }
          : r
      ));
      setNewQuestion("");
    }
  };

  const updateQuestion = (resumeId, index, updates) => {
    setResumes(resumes.map(r => 
      r.id === resumeId 
        ? { ...r, questions: r.questions.map((q, i) => (i === index ? { ...q, ...updates } : q)) }
        : r
    ));
  };

  const addResume = () => {
    if (newResumeName.trim() !== "") {
      const newId = resumes.length + 1;
      setResumes([...resumes, { id: newId, name: newResumeName, questions: [] }]);
      setCurrentResumeId(newId);
      setNewResumeName("");
      setIsAddingResume(false);
    }
  };

  const deleteResume = (resumeId) => {
    const updatedResumes = resumes.filter(r => r.id !== resumeId);
    setResumes(updatedResumes);
    if (resumeId === currentResumeId && updatedResumes.length > 0) {
      setCurrentResumeId(updatedResumes[0].id);
    } else if (updatedResumes.length === 0) {
      setCurrentResumeId(null);
    }
  };

  return (
    <div className="resume-container">
      <h1>자기소개서</h1>
      <div className="add-resume-section">
        {isAddingResume && (
          <div className="popup">
            <div className="popup-inner">
              <h2>새 자소서 추가</h2>
              <input
                type="text"
                value={newResumeName}
                onChange={(e) => setNewResumeName(e.target.value)}
                placeholder="자소서 이름을 입력하세요"
              />
              <div className="popup-buttons">
                <button onClick={addResume}>추가</button>
                <button onClick={() => setIsAddingResume(false)}>취소</button>
              </div>
            </div>
          </div>
        )}
        <button className="add-resume-button" onClick={() => setIsAddingResume(true)}>새 자소서 추가</button>
      </div>
      <div className="resume-tabs">
        {resumes.map(resume => (
          <div key={resume.id} className="resume-tab-container">
            <button 
              onClick={() => setCurrentResumeId(resume.id)}
              className={`resume-tab ${currentResumeId === resume.id ? 'active' : ''}`}
            >
              {resume.name}
            </button>
            {resumes.length > 1 && (
              <button onClick={() => deleteResume(resume.id)} className="delete-resume-button">삭제</button>
            )}
          </div>
        ))}
      </div>
      {currentResumeId && (
        <>
          <div className="add-question">
            <input
              type="text"
              value={newQuestion}
              onChange={(e) => setNewQuestion(e.target.value)}
              placeholder="새 문항을 입력하세요"
            />
            <button onClick={addQuestion}>문항 추가</button>
          </div>
          <div className="questions-list">
            {resumes.find(r => r.id === currentResumeId).questions.map((q, index) => (
              <div key={index} className="question-item">
                <div className="question-header" onClick={() => updateQuestion(currentResumeId, index, { isOpen: !q.isOpen })}>
                  <h3>{q.question}</h3>
                  <button>{q.isOpen ? "접기" : "열기"}</button>
                </div>
                {q.isOpen && (
                  <div className="answer-section">
                    {q.isEditing ? (
                      <>
                        <textarea
                          value={q.answer}
                          onChange={(e) => updateQuestion(currentResumeId, index, { answer: e.target.value })}
                          placeholder="답변을 작성하세요"
                        />
                        <div className="answer-buttons">
                          <button onClick={() => updateQuestion(currentResumeId, index, { isEditing: false })}>저장</button>
                          <button onClick={() => updateQuestion(currentResumeId, index, { isEditing: false })}>취소</button>
                        </div>
                      </>
                    ) : (
                      <>
                        <p>{q.answer}</p>
                        <button onClick={() => updateQuestion(currentResumeId, index, { isEditing: true })} className="edit-button">수정</button>
                      </>
                    )}
                  </div>
                )}
              </div>
            ))}
          </div>
        </>
      )}
    </div>
  );
};

export default Resume;
