import {expect, test} from "@playwright/test";
import {request} from "playwright";

test.describe('users endpoint', function() {
  test('should get a user', async ({ request }) => {
    const response = await request.get('/users/1');

    expect(response.status()).toEqual(200);
    expect(await response.json()).toStrictEqual({
      "id": 1,
      "firstName": "Nick",
      "lastName": "DeMarco",
      "username": "Gabagool King",
      "email": "ndemco@gmail.com"
    });
  });

  test("should create and delete user", async({ request }) => {
    const response = await request.post('/users/signup', {
      data: {
        "firstName": "Mike",
        "lastName": "DeMarco",
        "username": "Watsons Salon Spa",
        "email": "mdemco@gmail.com"
      }
    });

    const responseBody = await response.json();
    const id = responseBody.id

    expect(response.status()).toEqual(201);
    expect(await response.json()).toEqual({
      "id": 3,
      "firstName": "Mike",
      "lastName": "DeMarco",
      "username": "Watsons Salon Spa",
      "email": "mdemco@gmail.com"
    });
  });

  test.only("testing cookies", async({ request }) => {
    const response = await request.post('/users/login', {
      data: {
        "email": "ndemco@gmail.com",
        "password": "abc123"
      }
    })

    console.log(response.headers())
  })
});