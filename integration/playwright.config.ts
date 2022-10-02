import type { PlaywrightTestConfig } from '@playwright/test';

const config: PlaywrightTestConfig = {
    use: {
        // All requests we send go to this API endpoint.
        baseURL: 'http://localhost:8080',
    }
};
export default config;