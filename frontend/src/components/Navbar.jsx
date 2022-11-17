import React, { useState } from 'react';
import { BsPersonCircle } from "react-icons/bs";
import logo from '../logo-simple.png';
import Register from "./modals/Register";
import Login from "./modals/Login";
import axios from 'axios';
import styled from 'styled-components';
import '../styles/Navbar.css';

const Navbar = () => {

    const [stateModalRegister, setStateModalRegister] = useState(false); 
    const [stateModalLogin, setStateModalLogin] = useState(false);   

    const buttonsLogueado = () => {
        return(
            <>
                <div className="buttons-content">
                    <a className="button-nb" href={`/profile`} id="btn">PERFIL <BsPersonCircle className='icon-profile'/></a>
                </div>
            </>
        )
    };

    axios.defaults.headers['authorization'] = localStorage.getItem('token');
      
    const buttonsSinLoguearse = () => {
        return(
          <>
            <Boton onClick={() => setStateModalRegister(!stateModalRegister)}>REGISTRARSE</Boton>
            <Register state={stateModalRegister} setState={setStateModalRegister} setStateLogin={setStateModalLogin}/>
            <Boton onClick={() => setStateModalLogin(!stateModalLogin)}>INICIAR SESIÓN</Boton>
            <Login state={stateModalLogin} setState={setStateModalLogin} setStateRegister={setStateModalRegister}/>
          </>  
        )
    };

    const Buttons = !!localStorage.getItem("token") ? buttonsLogueado : buttonsSinLoguearse;

    return (
        <>
            <div className="navbar-container">
                <div className="col-lg-5 col-md-4 col-sm-5 col-xs-6 nav-left">
                    <Buttons/>
                    <span className='separador'>|</span>
                    <a className="button-nb" href={`/`} id="btn"> Inicio </a>
                    <a className="button-nb" href={`/hospitales`} id="btn"> Hospitales Adheridos</a>
                </div>
                <div className="col-lg-3 col-md-4 col-sm-1 col-xs-0 nav-medium">
                </div>
                <div className="col-lg-4 col-md-4 col-sm-6 col-xs-6 nav-right">
                    <div className="logo-content">
                        <a title="logo" id='logo' href="/"><img src={logo} alt="logo" height="80" width="80"/></a>
                    </div>
                </div>  
            </div>
        </>
    )
  }
  
  export default Navbar;

  const Boton = styled.button`
    display: block;
    width: 150px;
    height: 19px;
    border: none;
    color: #fff;
    border: none;
    margin: 5px;
    font-size: 13px;
    font-weight: 900;
    background-color: transparent;
    cursor: pointer;
    font-family: 'Roboto', sans-serif;
    font-weight: 900;
    transition: .3s ease all;
    &:hover {
      color: #A9D35A;
    }
  `;