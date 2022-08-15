import { useState, useEffect } from 'react';
import './App.css';
import { db } from './firebase-config';
import { collection, doc, updateDoc, getDocs } from 'firebase/firestore';
import { useNavigate } from 'react-router-dom';

function Login() {
  const [newName, setNewName] = useState('');
  const [newPassword, setNewPassword] = useState('');

  const [users, setUsers] = useState([]);
  const [states, setStates] = useState([]);
  const usersCollectionRef = collection(db, '5410_Users');
  const stateCollectionRef = collection(db, '5410_Users_State');

  //Retrieve User details from FireStore

  const getUsers = async () => {
    const data = await getDocs(usersCollectionRef);
    setUsers(data.docs.map((doc) => ({ ...doc.data(), id: doc.id })));
  };
  getUsers();

  //Retrieve State Info from FireStore
  const getUsersState = async () => {
    const dataState = await getDocs(stateCollectionRef);
    setStates(dataState.docs.map((doc) => ({ ...doc.data(), id: doc.id })));
  };
  getUsersState();

  //On submit Update Firebase State to True
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(users);
    for (let user of users) {
      const userDetails = { ...user };
      if (userDetails.Name == newName && userDetails.Password == newPassword) {
        const nm = userDetails.Name;
        console.log('USER EXISTS IN THE DB - VALIDATION SUCCESSFUL');
        console.log(newName);
        updateFirebase();
        // navigate('/Profile', { Name: nm });
        window.location.href = 'http://localhost:3002/' + nm;
      }
    }
  };

  const updateFirebase = async () => {
    const currentUser = states.filter((state) => {
      return state.Name == newName;
    });

    const loginUserDoc = doc(db, '5410_Users_State', currentUser[0].id);
    const onlineStatus = { Status: true };
    await updateDoc(loginUserDoc, onlineStatus);
  };

  return (
    <div class='pt-10'>
      <form onSubmit={handleSubmit} class='w-full max-w-sm'>
        <div class='md:flex md:items-center mb-6'>
          <div class='md:w-1/3'>
            <label
              class='block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4'
              for='inline-full-name'
            >
              Name
            </label>
          </div>
          <div class='md:w-2/3'>
            <input
              class='bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500'
              name='Name'
              type='text'
              placeholder='Name...'
              required='true'
              onChange={(event) => {
                setNewName(event.target.value);
              }}
            />
          </div>
        </div>

        <div class='md:flex md:items-center mb-6'>
          <div class='md:w-1/3'>
            <label
              class='block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4'
              for='inline-password'
            >
              Password{' '}
            </label>
          </div>
          <div class='md:w-2/3'>
            <input
              class='bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500'
              name='Password'
              type='password'
              placeholder='Password...'
              required='true'
              onChange={(event) => {
                setNewPassword(event.target.value);
              }}
            />
          </div>
        </div>

        <div class='md:flex md:items-center'>
          <div class='md:w-1/3'></div>
          <div class='md:w-2/3'>
            <button
              type='submit'
              class='shadow bg-purple-500 hover:bg-purple-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounded'
              // onClick={}
            >
              {' '}
              Login
            </button>
          </div>
        </div>
      </form>
    </div>
  );
}

export default Login;
