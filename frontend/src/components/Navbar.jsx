import React from 'react';
import logo from '../logo.png';
import '../styles/Navbar.css';

const Navbar = () => {
   
    return (
        <>
            <div className="navbar-container">
                <div className="nav">
                        <div className="box-title">  
                            <a title="logo" href="/"><img src={logo} alt="logo" height="130" width="130" /></a>
                        </div>
                    </div>
            </div>
        </>
    );
  }
  
  export default Navbar;