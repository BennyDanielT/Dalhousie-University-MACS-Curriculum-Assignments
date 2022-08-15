import { useState, useEffect } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css';
import Registration from './Registration';
import Login from './Login';
import Profile from './Profile';

function App() {
  return (
    <Router>
      <div>
        <Routes>
          <Route path='/' element={<Registration />} />
          {/* <Route path='/Login' element={<Login />} />
          <Route path='/Profile/:loggedInUser' element={<Profile />} /> */}
        </Routes>
      </div>
    </Router>
  );
}

export default App;

// import { BrowserRouter, Route, Switch } from 'react-router-dom';

// function App() {
//   return (
//     <div className="wrapper">
//       <h1>Application</h1>
//       <BrowserRouter>
//         <Switch>
//           <Route path="/dashboard">
//             <Dashboard />
//           </Route>
//           <Route path="/preferences">
//             <Preferences />
//           </Route>
//         </Switch>
//       </BrowserRouter>
//     </div>
//   );
// }
