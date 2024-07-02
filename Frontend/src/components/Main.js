import React from 'react';
import { useNavigate } from 'react-router-dom';
import './Form.css';

const Main = () => {
  const navigate = useNavigate();

  return (
    <div className="form-container">
      <h1>메인 페이지</h1>
      <div className="button-container">
        <button onClick={() => navigate('/login')}>
          로그인
        </button>
        <button onClick={() => navigate('/signup')}>
          회원가입
        </button>
      </div>
    </div>
  );
};

export default Main;
