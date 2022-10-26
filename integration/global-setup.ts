import {expect, FullConfig} from "@playwright/test";
import {request} from "playwright";

async function globalSetup(config: FullConfig) {
  await saveSessionAuth()
}

async function saveSessionAuth() {
  const requestContext = await request.newContext({baseURL: 'http://demco-ff-api:8080'})

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