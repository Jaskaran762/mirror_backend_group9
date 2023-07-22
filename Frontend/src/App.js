import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Login from "./components/authentication/Login";
import Home from "./components/Home";
import Signup from "./components/authentication/Signup";
import Error from "./components/Error";
import ForgotPassword from "./components/authentication/forgot";
import ContactPage from "./components/HomeNavOptions/Contact";
import ServicesPage from "./components/HomeNavOptions/Services";
import AboutPage from "./components/HomeNavOptions/About";
import MainPage from "./components/Landing-page/Main";
import Landing from "./components/Landing-page/landing";

import "bootstrap/dist/css/bootstrap.css";
import Itinerary from "./components/itinerary/itinerary";
import Wish from "./components/wishlist/Wish";
import UserProfile from "./components/UserProfile/profile";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
        <Route path="/forgot-password" element={<ForgotPassword />} />
        <Route path="/contact" element={<ContactPage />} />
        <Route path="/about" element={<AboutPage />} />
        <Route path="/services" element={<ServicesPage />} />
        <Route path="/mainpage" element={<MainPage />} />
        <Route path="/itinerary/:data" element={<Itinerary />} />
        <Route path="/wish/:data" element={<Wish />} />
        <Route path="/profile" element={<UserProfile />} />
        <Route path='/landing' element={<Landing />} />
      </Routes>
    </Router>
  );
}

export default App;