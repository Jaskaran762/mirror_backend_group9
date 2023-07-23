

import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "./components/authentication/Login";
import Home from "./components/Home";
import Signup from "./components/authentication/Signup";
import Error from "./components/Error";
import ForgotPassword from "./components/authentication/forgot";
import ContactPage from "./components/HomeNavOptions/Contact";
import ServicesPage from "./components/HomeNavOptions/Services";
import AboutPage from "./components/HomeNavOptions/About";
import MainPage from "./components/Landing-page/Main";

import "bootstrap/dist/css/bootstrap.css";
import Domestic from "./components/StartTrip/domestic";
import International from "./components/StartTrip/international";
import ItineraryPage from "./components/Itienary/Itienary";

function App() {
  return (
    <BrowserRouter>
      <Routes>

      <Route path='/' element={<Home/>}/>
      <Route path='/login' element={<Login/>}/>
      <Route path='/signup' element={<Signup/>}/>
      <Route path = '/forgot-password' element = {<ForgotPassword/>}/>
      <Route path='/contact' element = {<ContactPage/>}/>

      <Route path='/about' element = {<AboutPage/>}/>
      <Route path='/services' element = {<ServicesPage/>}/>
      <Route path='*' element={<Error/>}/>

        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
        <Route path="/forgot-password" element={<ForgotPassword />} />
        <Route path="/contact" element={<ContactPage />} />
        <Route path="/about" element={<AboutPage />} />
        <Route path="/services" element={<ServicesPage />} />
        <Route path="*" element={<Error />} />
        <Route path="/mainpage" element={<MainPage />} />
        <Route path = "/domestic" element = {<Domestic/>} />
        <Route path = "/international" element = {<International/>} />
        <Route path = "/itienary" element = {<ItineraryPage/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
