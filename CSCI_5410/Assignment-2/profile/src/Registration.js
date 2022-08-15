import { useState, useEffect } from 'react';
import './App.css';
import { db } from './firebase-config';
import { collection, getDocs, addDoc } from 'firebase/firestore';
import { useNavigate } from 'react-router-dom';

function Registration() {
  const navigate = useNavigate();

  const [newName, setNewName] = useState('');
  const [newPassword, setNewPassword] = useState('');
  const [newConfirmPassword, setNewConfirmPassword] = useState('');

  const [newEmail, setNewEmail] = useState('');

  const [newLocation, setNewLocation] = useState('');

  //5410_Users

  const [users, setUsers] = useState([]);
  const usersCollectionRef = collection(db, '5410_Users');
  const usersStateRef = collection(db, '5410_Users_State');

  //Add Data to a collection- To be Used in the Registration Page

  const createUser = async () => {
    await addDoc(usersCollectionRef, {
      Name: newName,
      Password: newPassword,
      Email: newEmail,
      Location: newLocation,
    });

    await addDoc(usersStateRef, {
      Name: newName,
      Status: false,
    });
    window.location.href = 'http://localhost:3001/';
  };

  return (
    <div class='pt-10'>
      <form class='w-full max-w-sm'>
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
              pattern='^[A-Za-z]{3,50}$'
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
              for='inline-email'
            >
              Email{' '}
            </label>
          </div>
          <div class='md:w-2/3'>
            <input
              class='bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500'
              name='Email'
              type='email'
              placeholder='Email...'
              required='true'
              onChange={(event) => {
                setNewEmail(event.target.value);
              }}
            />
          </div>
        </div>

        <div class='md:flex md:items-center mb-6'>
          <div class='md:w-1/3'>
            <label
              class='block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4'
              for='inline-location'
            >
              Location{' '}
            </label>
          </div>
          <div class='md:w-2/3'>
            <input
              class='bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500'
              name='Location'
              type='text'
              placeholder='Location...'
              pattern='^[A-Za-z]{3,50}$'
              required='true'
              onChange={(event) => {
                setNewLocation(event.target.value);
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
              pattern='^[A-Za-z0-9]{5,50}$'
              required='true'
              onChange={(event) => {
                setNewPassword(event.target.value);
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
              Confirm Password{' '}
            </label>
          </div>
          <div class='md:w-2/3'>
            <input
              class='bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500'
              name='Password'
              type='password'
              placeholder='Password...'
              pattern={newPassword}
              required='true'
              onChange={(event) => {
                setNewConfirmPassword(event.target.value);
              }}
            />
          </div>
        </div>

        <div class='md:flex md:items-center'>
          <div class='md:w-1/3'></div>
          <div class='md:w-2/3'>
            <button
              class='shadow bg-purple-500 hover:bg-purple-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounded'
              onClick={createUser}
            >
              {' '}
              Register User
            </button>
          </div>
        </div>
      </form>
    </div>
  );
}

export default Registration;
