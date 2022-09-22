import React, { useState, useEffect }   from 'react';
import { useParams  } from "react-router-dom";
import Service from '../Service/service';

const Hospital = () => {

    const { id } = useParams();
    
    const [hospital, setHospital] = useState("");

    useEffect(() => {
        Service.getHospitalById(id)
            .then(response => { 
            setHospital(response.data)
        }).catch(error => {
            console.log(error)
        });
    }, [id]
    );


    return (
        <>
            <div className="container">
                hola
            </div>
        </>  
    );
  }
  
  export default Hospital;