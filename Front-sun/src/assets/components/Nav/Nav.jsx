import "./Nav.css";
import Main from '../Main/Main';
import { Link } from 'react-router-dom';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import calenderIcon from '../../images/calendar.png'
import certiIcon from '../../images/certi_icon.png'
import graduateIcon from '../../images/graduate_icon.png'
import vector from '../../images/Vector.png'


const Nav = ({isLogIn, userProfile}) => {
  return (
    <div className="nav-container">
      <nav>
        <div className="isLogIn">
          {isLogIn ? (
              <>
              {/* 프로필 이미지 저장소 만들기 */}
                <img src={userProfile.profileImage} alt="Profile" />
                <div>{userProfile.username}</div>
              </>
            ) : (
              <>
                <Link to="/login">로그인</Link>
                <Link to="/signup">회원가입</Link>
              </>
            )}
          </div>
          
            <Link to="/main"><img src={calenderIcon}alt="Calendar Icon" />Main</Link>
            <Link to="/self-introduction"><img src={vector}alt="vector" />자기소개</Link>
            <Link to="/education-experience"><img src={graduateIcon}alt="graduateIcon" />학력/경력</Link>
            <Link to="/certifications-language-scores"><img src={certiIcon}alt="certiIcon" />자격/어학/성적</Link>
        
      </nav>
      
      <div className="main-content">
        <Routes>
          <Route path="/main" element={<Main />} />
          <Route path="/self-introduction" element={<div>자기소개 Page</div>} />
          <Route path="/education-experience" element={<div>학력/경력 Page</div>} />
          <Route path="/certifications-language-scores" element={<div>자격/어학/성적 Page</div>} />
        </Routes>
      </div>
    </div>
  )
}

export default Nav;