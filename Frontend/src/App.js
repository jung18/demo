import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Main from './components/Main';
import Sidebar from './components/Sidebar';
import Login from './components/Login';
import Signup from './components/Signup';
import Notifications from './components/Notifications';
import Resume from './components/Resume';
import Calendar from './components/Calendar';
import EducationAndExperience from './components/EducationAndExperience';
import Portfolio from './components/Portfolio'; // 새로 추가된 컴포넌트

import './App.css';

function App() {
  return (
    <Router>
      <div className="App">
        <Sidebar />
        <div className="content">
          <Routes>
            <Route path="/" element={<Main />} />
            <Route path="/login" element={<Login />} />
            <Route path="/signup" element={<Signup />} />
            <Route path="/schedule" element={<Calendar />} />
            <Route path="/notifications" element={<Notifications />} />
            <Route path="/resume" element={<Resume />} />
            <Route path="/education" element={<EducationAndExperience />} />
            <Route path="/portfolio" element={<Portfolio />} />
          </Routes>
        </div>
      </div>
    </Router>
  );
}

export default App;
