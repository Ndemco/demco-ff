import type { PlaywrightTestConfig } from '@playwright/test';

const config: PlaywrightTestConfig = {
    use: {
        // All requests we send go to this API endpoint.
        baseURL: 'http://demco-ff-api:8080',
        extraHTTPHeaders: {
            "Cookie": process.env.HEADER_COOKIE
        }
    },
    globalSetup: require.resolve('./global-setup'),
    globalTeardown: require.resolve('./global-teardown')
};

export default config;