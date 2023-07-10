import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './App.css';

function Main() {
  const [data, setData] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.post('http://localhost:8080/api/member', null, {
          withCredentials: true,
          headers: {
            'Content-Type': 'application/json'
          }
        });
        setData(response.data);
        console.log(response.data);
      } catch (error) {
        console.error(`에러: ${error}`);
      }
    };

    fetchData();
  }, []);

  return (
    <div className="App">
      <div>프로필</div>
      <button><a href='http://localhost:8080/logout'>logout</a></button>
      {data && (
        <div>
          <div>Nickname: {data.nickname}</div>
          <div>Profile Image: {data.profileImg}</div>
          <div>Username: {data.username}</div>
          <div>Email: {data.email}</div>
        </div>
      )}
    </div>
  );
}

export default Main;
