# CSCI 5709 - Assignment 1

This tutorial deals with Code Management and Deployment with GitLab and Heroku.

* *Date Created*: 01 June 2022
* *Last Modification Date*: 01 June 2022
* *GitLab  URL*: https://git.cs.dal.ca/benny/CSCI_5709_ASSIGNMENTS_B00899629_BENNY_THARIGOPALA/-/tree/Assignment-1
* Heroku Application URL: https://csci-5709-a1-benny-tharigopala.herokuapp.com/

## Authors

* [Benny Daniel Tharigopala](bn489600@dal.ca) - *(Developer)*


## Getting Started

### Prerequisites

To have a local copy of this tutorial up and running on your local machine, you will first need to install the following software / libraries / plug-ins

```
Git CLI
Heroku CLI
```

See the following section for detailed step-by-step instructions on how to install this software

### Installing

Refer to the following documents for notes on installation:

1. Git - https://git-scm.com/book/en/v2/Getting-Started-Installing-Git
2. Heroku - https://devcenter.heroku.com/articles/heroku-cli
3. Node Modules - Navigate to the project directory of the project and execute the following commands:


```shell
$ `npm i`- To install all the required packages for front-end
$ `npm start` - This starts the development server

Open [http://localhost:3000] (http://localhost:3000) to view the application in your browser.
```


## URLS

|          Title          |                   URL                    |
| :---------------------: | :--------------------------------------: |
|       GitLab  URL       | https://git.cs.dal.ca/benny/CSCI_5709_ASSIGNMENTS_B00899629_BENNY_THARIGOPALA/-/tree/Assignment-1 |
| Heroku Application URL: | https://csci-5709-a1-benny-tharigopala.herokuapp.com/ |



## Deployment

To deploy this application on a live system, download the Source Code and push it to a platform such as Heroku.

```shell
Use Git to clone the source code to your local machine.
$ heroku git:clone -a csci-5709-a1-benny-tharigopala
$ cd csci-5709-a1-benny-tharigopala	
```

#### Deploy your changes

Make some changes to the code you just cloned and deploy them to Heroku using Git.

```shell
$ git add .
$ git commit -am ""
$ git push heroku master
```

Note: Instructions obtained from: https://devcenter.heroku.com/articles/git



## Built Withs

* [ReactJS](https://reactjs.org/) - The JavaScript library used for building the application.

* [Bootstrap](https://getbootstrap.com/) - CSS Framework for design templates, typography and other interface components.

* [Node.js](https://nodejs.org/en/) - Back-end JavaScript runtime environment

* [Visual Studio](https://visualstudio.microsoft.com/) - Code Editor

  ​

## Sources Used

### <u>App.css</u>

Line 3

```css
background-image: linear-gradient(to right, #0f0c29, #302b63, #24243e);

```

The code above was created by adapting the code in [makeuseof.com](https://www.makeuseof.com/css-background-gradients/) as shown below: 

```css
background-image: linear-gradient(-20deg, #00cdac 0%, #8ddad5 100%);
```

- The code in [makeuseof.com](https://www.makeuseof.com/css-background-gradients/) was implemented by making use of the CSS property "linear-gradient" in App.css.
- [makeuseof.com](https://www.makeuseof.com/css-background-gradients/)'s Code was used to render a simplistic yet professional background for Assignment-1.
- [makeuseof.com](https://www.makeuseof.com/css-background-gradients/)'s Code was modified by changing the "side-or-corner" & "color-stop-list" properties of the "linear-gradient" attribute.

### <u>Cards.tsx</u>

Lines 42-51

```react
<Card style={{ width: '50%', margin: '25px' }}>
                <Card.Body>
                  <Card.Title>You do not have any Payment Methods</Card.Title>
                </Card.Body>
              </Card>
```

The code above was created by adapting the code in [react-bootstrap](https://react-bootstrap.github.io/components/cards/) as shown below: 

```react
<Card style={{ width: '50%', margin: '25px' }}>
                <Card.Body>
                  <Card.Title>You do not have any Payment Methods</Card.Title>
                  <Card.Subtitle className='mb-2 text-muted'>
                    Add a Payment Method to continue
                  </Card.Subtitle>
                </Card.Body>
              </Card>
```

- The code in [react-bootstrap](https://react-bootstrap.github.io/components/cards/) was implemented by making use of Bootstrap Cards in Cards.tsx.
- [react-bootstrap](https://react-bootstrap.github.io/components/cards/)'s Code was used to develop and render cards which resemble real-world Credit Cards.
- [react-bootstrap](https://react-bootstrap.github.io/components/cards/)'s Code was modified by adding an image to the card, updating the width & margins, applying suitable CSS classes and a link to add a new card.

### <u>AddCard.tsx</u>

Line 58-72

```css
<CardForm
              selectedCreditCard={state}
              onUpdateState={updateStateValues}
              handleSubmitAction={handleSubmitAction}
            >
              <Card
                cardNumber={state.cardNumber}
                cardHolder={state.cardHolder}
                cardMonth={state.cardMonth}
                cardYear={state.cardYear}
                cardCvv={state.cardCvv}
              ></Card>
            </CardForm>
```

The code above was created by adapting the code in [codesandbox](https://codesandbox.io/s/9y8vkrrx9o) as shown below: 

```css
 <form onSubmit={handleSubmit}>
            <Card
              number={values.number || ''}
              name={values.name || ''}
              expiry={values.expiry || ''}
              cvc={values.cvc || ''}
              focused={active}
            />
            <div>
              <Field
                name="number"
                component="input"
                type="text"
                pattern="[\d| ]{16,22}"
                placeholder="Card Number"
                format={formatCreditCardNumber}
              />
          </form>
```

- The code in [codesandbox](https://codesandbox.io/s/9y8vkrrx9o)  was implemented by making use of Cards, State and Properties in AddCard.tsx.
- [codesandbox](https://codesandbox.io/s/9y8vkrrx9o) 's Code was used to create a Form that accepts Card details and adds a new card to the "Payment Method" page in Assignment-1.
- [codesandbox](https://codesandbox.io/s/9y8vkrrx9o) 's Code was modified by creating an interface for Credit Cards and importing the interface in the Form to accept and store Credit Card information in the "Payment Methods" page.

### <u>CreditCard.ts</u>

Line 3

```css
export function updateLocalStorageCards(cards: CreditCard[]) {
  localStorage.setItem('cards', JSON.stringify(cards));
}
```

The code above was created by adapting the code in [makeuseof.com](https://www.makeuseof.com/css-background-gradients/) as shown below: 

```css
localStorage.setItem("itemname", JSON.stringify(obj)); // Save the obj as string
var item = JSON.parse(localStorage.getItem("itemname")); 
// ^^ Parse string then set `item` as the obj
```

- The code in [codegrepper](https://www.codegrepper.com/code-examples/javascript/update+localstorage+react) was implemented by making use of the LocalStorage functionality.
- [codegrepper](https://www.codegrepper.com/code-examples/javascript/update+localstorage+react)'s Code was used to store Credit Card information to Local Storage for Assignment-1.
- [codegrepper](https://www.codegrepper.com/code-examples/javascript/update+localstorage+react)'s Code was modified by changing the parameters passed to the "setItem" function.




## Snippets

### Add Payment Method Page

![HomePage](HomePage.png)

### Add Card Page

![Add_Cards_Page](Add_Cards_Page.png)

### Card Details

![card_details](card_details.png)

### Card Added to Payment Methods

![card_added](card_added.png)

## References:

1. Hall, Mars. “Heroku Buildpack for Create-React-App.” *GitHub*, 3 Feb. 2022, github.com/mars/create-react-app-buildpack#usage. Accessed 23 May 2022.
2. admin. “How to Make React Credit Card Payment System Project Beginners.” *Hzonesp*, 30 Mar. 2018, hzonesp.com/programming/how-to-make-react-credit-card-payment-system-project-beginners/. Accessed 14 May 2022.
3. “Credit Card Payment UI with ReactJS.” *DEV Community*, 11 Mar. 2017, dev.to/hyggedev/credit-card-payment-ui-with-reactjs-1a5a. Accessed 8 May 2022.
4. “How to Add Credit Card Payment System with Stripe in React.” *CodeSource.io*, 5 July 2017, codesource.io/how-to-add-credit-card-payment-system-with-stripe-in-react/. Accessed 17 May 2022.

## 