import React from 'react';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import './App.css';
import Login from './login';
import Main from './main';

function App() {
  return (
    <BrowserRouter>
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/main" element={<Main />} />
            </Routes>
    </BrowserRouter>
  );
}

export default App;
