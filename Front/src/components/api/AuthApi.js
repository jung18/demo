import axios from 'axios'
import axiosInstance from './AxiosInstance';

// 로그인
export const fetchLogin = (email, password) => {
  return axiosInstance.post('/user/login', {
    email,
    password
  }).then(response => {
    return response;
  }).catch(error => {
    throw error; 
  });
};


// 회원가입 
export const fetchSignup = (userId, username, email, password, confirmPassword) => {
  return axiosInstance.post('/user/signup', {
    userId,
    username, 
    email, 
    password, 
    confirmPassword
  }).then(response => {
    return response;
  }).catch(error => {
    console.error('회원가입 요청 에러:', error.response ? error.response.data : error.message)
    throw error; 
  });
};

