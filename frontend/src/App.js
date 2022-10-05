import { BrowserRouter, Route, Routes } from 'react-router-dom';
import React from 'react';
import Navbar from './components/Navbar';
import Home from './components/Home';
import Search from './components/Search';
import Hospital from './components/Hospital';
import FormTurno from './components/FormTurno';

const App = () => {

  return (
    <BrowserRouter>
      <div className="navbar">
        <Navbar/>
      </div> 
      <Routes>
        <Route exact path="/" element={<Home/>} />
        <Route path="/hospital/search" element={<Search/>}/>
        <Route path="/hospital/:id/especialidades" element={<Hospital/>}/>
        <Route path="/hospital/:id/:especialidad/sacar-turno" element={<FormTurno/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
