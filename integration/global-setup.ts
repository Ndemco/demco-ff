import {expect, FullConfig} from "@playwright/test";
import {request} from "playwright";

async function globalSetup(config: FullConfig) {
  await setup();
}

async function setup() {
  const requestContext = await request.newContext({ baseURL: 'http://demco-ff-api:8080' })

  await requestContext.post('/users/signup', {
    data: {
      "firstName": "Nick",
      "lastName": "DeMarco",
      "username": "ndemco",
      "email": "ndemco@gmail.com",
      "password": "abc123abc123"
    }
  })

  let response = await requestContext.post('/users/login', {
    form: {
      'email': 'ndemco@gmail.com',
      'password': 'abc123abc123'
    }
  })
  expect(response.status()).toEqual(200)

  process.env.HEADER_COOKIE = response.headers()['set-cookie'].split(';')[0]
}

export default globalSetup;