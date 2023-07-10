import React from 'react';
import './App.css';

function Login() {
  return (
    <div className="App">
      깃허브 로그인
      <button><a href='http://localhost:8080/oauth2/authorization/github'>로그인</a></button>
    </div>
  );
}

export default Login;
