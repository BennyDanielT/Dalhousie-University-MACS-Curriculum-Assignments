import { useState } from 'react';
import './App.css';
import { db } from './firebase-config';
import { collection, doc, getDocs, updateDoc } from 'firebase/firestore';
import { useNavigate, useParams } from 'react-router-dom';

function Profile() {
  // const { loggedInUser, ...others } = props;

  let { loggedInUser } = useParams();

  console.log(loggedInUser);
  const navigate = useNavigate();

  //console.log({ props });

  const [users, setUsers] = useState([]);
  const usersCollectionRef = collection(db, '5410_Users_State');
  const stateCollectionRef = collection(db, '5410_Users_State');

  //Retrieve and render Users who're Online

  const getUsers = async () => {
    const data = await getDocs(usersCollectionRef);
    setUsers(data.docs.map((doc) => ({ ...doc.data(), id: doc.id })));
  };
  getUsers();

  const onlineUsers = users.filter((user) => {
    return user.Status == true; //AND User.name!= loggedInUser
  });

  const listItems = onlineUsers.map((user) => (
    <tr>
      {' '}
      <td
        scope='row'
        class='px-6 py-1 font-medium text-gray-900 dark:text-white whitespace-nowrap'
      >
        {user.Name}
      </td>
    </tr>
  ));

  //Logout Function

  const handleLogout = async () => {
    updateFirebase();
    window.location.href = 'http://localhost:3001/';
  };

  const updateFirebase = async () => {
    const currentUser = users.filter((user) => {
      return user.Name == loggedInUser;
    });
    const logOffUserDoc = doc(db, '5410_Users_State', currentUser[0].id);
    const onlineStatus = { Status: false };
    await updateDoc(logOffUserDoc, onlineStatus);
  };
  //End of Logout function
  return (
    <div class='flex h-screen'>
      <div class='m-auto px-10 py-10'>
        <h1 class='px-10 py-10'>Hey There {loggedInUser} !</h1>
        <table class='px-10 py-10'>
          <thead class='text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400'>
            <tr class='border-b dark:bg-gray-800 dark:border-gray-700 odd:bg-white even:bg-gray-50 odd:dark:bg-gray-800 even:dark:bg-gray-700'>
              <th class='px-6 py-4 font-large text-gray-900 dark:text-white whitespace-nowrap'>
                Users Currently Online:
              </th>
            </tr>
            {listItems}
          </thead>
        </table>
        <div></div>
        <div class='px-10 py-10'>
          <button
            onClick={handleLogout}
            class='grid 
            .365
            place-items-center shadow bg-purple-500 hover:bg-purple-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounded m-auto'
            // onClick={}
          >
            {' '}
            Logout
          </button>
        </div>
      </div>
    </div>
  );
}

export default Profile;
