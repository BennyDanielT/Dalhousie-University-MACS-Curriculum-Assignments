FROM node:13.12.0-alpine

WORKDIR /app

ENV PATH /app/node_modules/.bin:$PATH

COPY package.json ./

COPY package-lock.json ./

EXPOSE 3002

RUN npm install --silent

RUN npm install react-scripts@5.0.1 -g --silent

COPY . ./

CMD ["npm", "start", "set", "PORT", "=", "3002"]