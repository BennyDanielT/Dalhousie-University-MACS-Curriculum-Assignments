# Assignment 3

## Author Metadata

1.  _Author_: **Benny Daniel Tharigopala**
2.  _Banner Id_: B00899629
3.  _Group No_: 24

## **Feature: In-App Payment Integration**

## Files that I have authored

**Frontend**
1. frontend/src/components/Payments/InitiatePayment.jsx
2. frontend/src/components/Payments/PaymentMethod.jsx
3. frontend/src/components/Payments/PaymentStatus.jsx
4. frontend/src/components/Payments/PaymentHistory.jsx
5. frontend/src/components/Payments/checkout.jsx
6. frontend/src/redux/actions/transaction.jsx
7. frontend/src/redux/reducers/transaction.jsx
8. frontend/src/redux/sagas/transaction.jsx
9. frontend/src/routing/index.js (Team-Effort)

**Backend**
1. backend/controllers/transaction.js
2. backend/routes/index.js (Team-Effort)

## Folder Structure

**Frontend**
* For frontend the folder structure used is the default react folder structure.
* All the assets are stored in frontend/src/assets.
* All the React Components are stored in frontend/src/components.
* All the css files other then App.css and index.css are stored in frontend/src/css.
* The redux structure containing actions, reducers and sagas in frontend/src/redux.

**Backend**
* For backend the folder structure used is the default nodejs and expressjs folder structure.
* All the API logic and end points are stored in backend/controllers.
* All the models or database connection are stored in backend/models.
* All the backend routes are stored in backend/routes.

## Prerequisites

To have a local copy of this lab / assignment / project up and running on your local machine, you will first need to
install the following software / libraries / plug-ins
```
NodeJS: Latest LTS version download from https://nodejs.org/en/.
Git: Latest source release download from https://git-scm.com/downloads.
```
See the following section for detailed step-by-step instructions on how to install this software / libraries / plug-ins

## Deployment

**Deployment and repositories**

_URL_ : http://group24-expensetracker-dev.us-east-1.elasticbeanstalk.com/login

_Repository Address_ : https://git.cs.dal.ca/ayushv/group24_expensetracker

*Default development Branch* : [dev](https://git.cs.dal.ca/ayushv/group24_expensetracker/-/tree/dev)

*Individual development Branch* : [benny-tharigopala-b00899629](https://git.cs.dal.ca/ayushv/group24_expensetracker/-/tree/benny-tharigopala-b00899629)

## Installation

Run the following commands in both the frontend and backend root folder to install and run the application
```
npm install
npm start
```


1. Create an AWS account from [here](https://portal.aws.amazon.com/billing/signup).
2. Install elastic beanstalk client using from [here](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/eb-cli3-install.html)
3. Run the following commands
```
eb init
eb create
eb deploy
```

## Built With

**Frontend**
- [ReactJS](https://reactjs.org/) - The core web library (framework) used.
- [React Router DOM](https://v5.reactrouter.com/) - Routing library for single page application.
- [React Bootstrap](https://react-bootstrap.github.io/) - User Interface components for React.
- [SweetAlert2](https://sweetalert2.github.io/) - Beautiful Alerts for React.

**Backend**
* [Node](https://nodejs.org/en/) - The core backend library (framework) used.
* [Express](https://expressjs.com/) - Framework for creating single page routes.
* [Postgresql](https://www.postgresql.org/) - SQL Database for the application.
* [Supabase](https://supabase.com/) - API Client for PostgreSQL.
* [Docker](https://www.docker.com/) - Creating single container for frontend and backend folder.
* [AWS Elastic Beanstalk](https://aws.amazon.com/elasticbeanstalk/) - Used for deploying both frontend and backend applications using Docker.


## Testing The Feature:

1. Input the Details for the Transaction in the "Initiate-Payment" page. Details for each Transaction include - 
  1.1 A description of what the payment is for
  1.2 The Transaction Amount
  1.3 Notes relevant to the transaction
  1.4 Notes relevant to the transaction
  1.5 Email Address of the Payee which will be used for the payment
  1.5 First & Last Name of the Payee

2. Click on Submit

  2.1. View Transaction Details Summary

  2.2. Input Card Number 

  ​	2.2.1 (4242424242424242) for Testing a Valid Card
  ​	2.2.2 (4000000000009995) for Testing a Invalid Card. Please refer to      [Stripe Cards Tests](https://stripe.com/docs/testing) for more Valid and Invalid Card numbers for Testing.

  2.3. Input Expiration Month and Year (Any Valid Month and Year in the future)

  2.4. Input CVC (Any valid 3 digit number)

  2.5. Input Country and Postal Code

  2.6. Click on Pay Now

3. View Payment Status

4. Payment History:
  4.1 Navigate to the Payment History Page
  4.2 Update the Filters for Date and Amount
  4.3 View the Transaction History corresponding to the Filters