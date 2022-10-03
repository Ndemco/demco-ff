import {expect, test} from "@playwright/test";

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
    const postResponse = await request.post('/users/signup', {
      data: {
        "firstName": "Mike",
        "lastName": "DeMarco",
        "username": "Watsons Salon Spa",
        "email": "mdemco@gmail.com",
        "password": "password"
      }
    });

    const postResponseBody = await postResponse.json();
    const id = postResponseBody.id

    expect(postResponse.status()).toEqual(201);
    expect(postResponseBody).toEqual({
      "id": 3,
      "firstName": "Mike",
      "lastName": "DeMarco",
      "username": "Watsons Salon Spa",
      "email": "mdemco@gmail.com"
    });

    const deleteResponse = await request.delete(`/users/${id}`)

    expect(await deleteResponse.json()).toEqual({
      "id": 3,
      "firstName": "Mike",
      "lastName": "DeMarco",
      "username": "Watsons Salon Spa",
      "email": "mdemco@gmail.com"
    })
  });

  test.skip("testing cookies", async ({ request }) => {
    const response = await request.post('/users/login', {
      form: {
        'email': 'ndemco@gmail.com',
        'password': 'abc123abc123'
      }
    })

    console.log(response.headers())
  })
});