import {expect, request as requestContext, test} from "@playwright/test";

test.describe('users endpoint', function() {
  test('should get a user', async ({ request }) => {
    const response = await request.get('/users/user/1');

    expect(response.status()).toEqual(200);
    expect(await response.json()).toStrictEqual({
      "id": 1,
      "firstName": "Nick",
      "lastName": "DeMarco",
      "username": "ndemco",
      "email": "ndemco@gmail.com",
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
      "id": id,
      "firstName": "Mike",
      "lastName": "DeMarco",
      "username": "Watsons Salon Spa",
      "email": "mdemco@gmail.com"
    });

    const deleteResponse = await request.delete(`/users/user/${id}`)

    expect(await deleteResponse.json()).toEqual({
      "id": id,
      "firstName": "Mike",
      "lastName": "DeMarco",
      "username": "Watsons Salon Spa",
      "email": "mdemco@gmail.com"
    })
  });

  test("should fail without a session", async() => {
    const newRequestContext = await requestContext.newContext({ baseURL: 'http://demco-ff-api:8080' })

    const response = await newRequestContext.get('/users/user/1');

    expect(response.status()).toEqual(401)
  })

  test("should fail to login with invalid credentials", async () => {
    const newRequestContext = await requestContext.newContext({ baseURL: 'http://demco-ff-api:8080' })

    const response = await newRequestContext.post('/users/login', {
      form: {
        'email': 'notarealperson@email.com',
        'password': 'thispassworddoesntexist'
      }
    })

    expect(response.status()).toEqual(401)
  });
});