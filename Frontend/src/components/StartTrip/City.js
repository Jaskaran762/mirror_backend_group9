import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import axios from 'axios';

const City = () => {
    const [cityDetail,setCityDetail] = useState();
    
    const {cityID}=useParams();
    const token = sessionStorage.getItem('token');
    const headers = {
    Authorization: `Bearer ${token}`,
    };
    const cityIDAsNumber = parseInt(cityID, 10);
    console.log(cityIDAsNumber);
    useEffect(()=>{
    axios.post('http://localhost:8091/home/city', { cityID:cityIDAsNumber}, { headers })
      .then((response) => {
        console.log(response.data);
        setCityDetail(response.data);
      })
      .catch((error) => {
        console.error('Error fetching domestic regions:', error);
      });

    },[])
  return (
    <div></div>
  )
}

export default City