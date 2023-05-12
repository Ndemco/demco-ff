import {expect, FullConfig} from "@playwright/test";
import {request} from "playwright";

async function globalTeardown(config: FullConfig) {
  await teardown()
}

async function teardown() {
  // use this if we need any sort of post-test cleanup
}

export default globalTeardown;