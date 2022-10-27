# demco-ff-api
A fantasy football app written in Kotlin using Ktor.

# Running Integration Tests
<li>
    Install and run Docker: https://docs.docker.com/get-docker/
</li>
<li>
    In the command line, from the repo directory, run 'script/test'
</li>
<li>
    That's it!
</li>

<h1> Running demco-ff-api (non-dockerized)</h1>
<br>
<li>Make the following additions to the respective 'hosts' file depending on your OS<br>
<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Mac / Linux:</b> /etc/hosts <br>
<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Windows:</b> C:\Windows\System32\drivers\etc\hosts
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;127.0.0.1 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; db<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;127.0.0.1 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; redis<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;127.0.0.1 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; demco-ff-api<br>
</li>

<li>Comment out the 'demco-ff-api' and 'playwright-tests' blocks from /integration/docker-compose.yml</li>

<li>Run 'script/test' from inside the repository directory (we still need to spin up the db and redis containers)</li>

<li>Run 'npx playwright test' from within the /integration directory</li>
