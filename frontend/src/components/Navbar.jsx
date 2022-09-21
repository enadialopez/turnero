import React from 'react';
import logo from '../logo.png';
import '../styles/Navbar.css';

const Navbar = () => {
   
    return (
        <>
            <div className="navbar-container col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div className="nav">
                        <div className="box-title">  
                            <a title="logo" href="/"><img src={logo} alt="logo" height="150" width="150" /></a>
                        </div>
                    </div>
            </div>
        </>
    );
  }
  
  export default Navbar;