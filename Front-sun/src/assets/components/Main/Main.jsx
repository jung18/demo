// import "./Main.css";
// import React, { Component } from 'react';
// import FullCalendar from '@fullcalendar/react';
// import dayGridPlugin from '@fullcalendar/daygrid';

// const Main = () => {
//   return (
//     <div className="main-container">
//       <FullCalendar 
//               defaultView="dayGridMonth" 
//               plugins={[ dayGridPlugin ]}
//             />
//     </div>
//   )
// }

// export default Main;

// src/Main.js
import React, { useEffect, useState } from 'react'; // React 및 필요한 Hooks 임포트
import FullCalendar from '@fullcalendar/react'; // FullCalendar 컴포넌트 임포트
import dayGridPlugin from '@fullcalendar/daygrid'; // dayGrid 플러그인 임포트
import googleCalendarPlugin from '@fullcalendar/google-calendar'; // Google Calendar 플러그인 임포트
import { gapi } from 'gapi-script'; // 구글 API 스크립트 임포트

// 구글 API 클라이언트 ID 및 API 키 설정
const CLIENT_ID = '612206131721-cd7qel69ts8pik7s91il9hb7dingclqp.apps.googleusercontent.com';
const API_KEY = 'AIzaSyBr7aXn5sges78uJPKQZAJ4sGU0uUD-2Xc';

// 구글 Calendar API를 사용하기 위한 Discovery 문서 및 범위 정의
const DISCOVERY_DOCS = ["https://www.googleapis.com/discovery/v1/apis/calendar/v3/rest"];
const SCOPES = "https://www.googleapis.com/auth/calendar.readonly";

const Main = () => {
  const [isSignedIn, setIsSignedIn] = useState(false); // 로그인 상태를 관리하는 상태 훅

  // 컴포넌트가 마운트될 때 구글 API 클라이언트를 초기화
  useEffect(() => {
    const initClient = () => {
      gapi.client.init({
        apiKey: API_KEY,
        clientId: CLIENT_ID,
        discoveryDocs: DISCOVERY_DOCS,
        scope: SCOPES,
      }).then(() => {
        const authInstance = gapi.auth2.getAuthInstance();
        setIsSignedIn(authInstance.isSignedIn.get()); // 초기 로그인 상태 설정
        authInstance.isSignedIn.listen(setIsSignedIn); // 로그인 상태 변화 리스너 설정
      });
    };

    gapi.load('client:auth2', initClient); // 구글 API 클라이언트 및 OAuth2 라이브러리 로드
  }, []);

  // 로그인 버튼 클릭 시 호출되는 함수
  const handleAuthClick = () => {
    gapi.auth2.getAuthInstance().signIn();
  };

  // 로그아웃 버튼 클릭 시 호출되는 함수
  const handleSignoutClick = () => {
    gapi.auth2.getAuthInstance().signOut();
  };

  return (
    <div className="main-container">
      {/* 사용자가 로그인하지 않은 경우 로그인 버튼 표시 */}
      {!isSignedIn ? (
        <button onClick={handleAuthClick}>Sign in with Google</button>
      ) : (
        <>
          {/* 사용자가 로그인한 경우 로그아웃 버튼 및 FullCalendar 컴포넌트 표시 */}
          <button onClick={handleSignoutClick}>Sign out</button>
          <FullCalendar
            defaultView="dayGridMonth"
            plugins={[dayGridPlugin, googleCalendarPlugin]}
            googleCalendarApiKey={API_KEY}
            events={{
              googleCalendarId: 'primary' // 'primary'는 사용자의 기본 캘린더를 나타냄
            }}
          />
        </>
      )}
    </div>
  );
};

export default Main; // Main 컴포넌트 내보내기