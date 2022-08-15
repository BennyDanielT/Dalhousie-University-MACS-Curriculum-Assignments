import { initializeApp } from 'firebase/app';
import { getFirestore } from '@firebase/firestore';

const firebaseConfig = {
  apiKey: 'AIzaSyA_x-128z76foVdorKfrJoGLj1RbAhwKyw',
  authDomain: 'a2bn489600.firebaseapp.com',
  projectId: 'a2bn489600',
  storageBucket: 'a2bn489600.appspot.com',
  messagingSenderId: '279529588005',
  appId: '1:279529588005:web:9e7536da3729f37d5c06cc',
  measurementId: 'G-TQZ86PN4T6',
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
export const db = getFirestore(app);
