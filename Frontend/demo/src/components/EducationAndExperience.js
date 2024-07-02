import React, { useState } from 'react';
import './EducationAndExperience.css';

const EducationAndExperience = () => {
  const [education, setEducation] = useState([]);
  const [experience, setExperience] = useState([]);
  
  const [newEducation, setNewEducation] = useState({ school: '', degree: '', year: '' });
  const [newExperience, setNewExperience] = useState({ company: '', title: '', years: '' });

  const addEducation = () => {
    setEducation([...education, newEducation]);
    setNewEducation({ school: '', degree: '', year: '' });
  };

  const addExperience = () => {
    setExperience([...experience, newExperience]);
    setNewExperience({ company: '', title: '', years: '' });
  };

  return (
    <div className="education-experience-container">
      <h1>학력 및 경력</h1>
      
      <div className="section">
        <h2>학력</h2>
        <input 
          type="text" 
          placeholder="학교 이름" 
          value={newEducation.school}
          onChange={(e) => setNewEducation({ ...newEducation, school: e.target.value })}
        />
        <input 
          type="text" 
          placeholder="학위" 
          value={newEducation.degree}
          onChange={(e) => setNewEducation({ ...newEducation, degree: e.target.value })}
        />
        <input 
          type="text" 
          placeholder="졸업 연도" 
          value={newEducation.year}
          onChange={(e) => setNewEducation({ ...newEducation, year: e.target.value })}
        />
        <button className="styled-button" onClick={addEducation}>추가</button>
        <ul>
          {education.map((edu, index) => (
            <li key={index}>{edu.school} - {edu.degree} ({edu.year})</li>
          ))}
        </ul>
      </div>

      <div className="section">
        <h2>경력</h2>
        <input 
          type="text" 
          placeholder="회사 이름" 
          value={newExperience.company}
          onChange={(e) => setNewExperience({ ...newExperience, company: e.target.value })}
        />
        <input 
          type="text" 
          placeholder="직책" 
          value={newExperience.title}
          onChange={(e) => setNewExperience({ ...newExperience, title: e.target.value })}
        />
        <input 
          type="text" 
          placeholder="근무 기간" 
          value={newExperience.years}
          onChange={(e) => setNewExperience({ ...newExperience, years: e.target.value })}
        />
        <button className="styled-button" onClick={addExperience}>추가</button>
        <ul>
          {experience.map((exp, index) => (
            <li key={index}>{exp.company} - {exp.title} ({exp.years})</li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default EducationAndExperience;
