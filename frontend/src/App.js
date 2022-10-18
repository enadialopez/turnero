import { BrowserRouter, Route, Routes } from 'react-router-dom';
import React from 'react';
import Navbar from './components/Navbar';
import Home from './components/Home';
import Search from './components/Search';
import Hospital from './components/Hospital';
import FormTurno from './components/FormTurno';
import Turno from './components/Turno';
import Register from './components/Register';

const App = () => {

  return (
    <BrowserRouter>
      <Routes>
        <Route exact path="/" element={<Home/>} />
        <Route path="/register" element={<Register/>}/>
        <Route path="/hospital/search" element={<Search/>}/>
        <Route path="/hospital/:id/especialidades" element={<Hospital/>}/>
        <Route path="/hospital/:id/:especialidad/sacar-turno" element={<FormTurno/>}/>
        <Route path="/hospital/turno/:id" element={<Turno/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
