import {expect, FullConfig} from "@playwright/test";
import {request} from "playwright";

async function globalTeardown(config: FullConfig) {
  await teardown()
}

async function teardown() {
  const requestContext = await request.newContext({
    baseURL: 'http://demco-ff-api:8080',
    extraHTTPHeaders: {
      "Cookie": process.env.HEADER_COOKIE
    }
  })

  let response = await requestContext.delete('/users/user/1');
  expect(response.status()).toEqual(200);
}

export default globalTeardown;