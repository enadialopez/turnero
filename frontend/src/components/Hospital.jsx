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

    console.log(hospital)

    return (
        <>
            <div className="container">
                    {hospital.nombre}
            </div>
        </>  
    );
  }
  
  export default Hospital;