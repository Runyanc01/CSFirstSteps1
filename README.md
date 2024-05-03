# CSFirstSteps

Because of packaging issues and configuration changes from previous versions of this framework, there have been issues deploying the final site that are beyond the time constraints of the project. In order to run the site as intended, you will need to pull from the master, clone the repository, and either open the project in a heavily modified version of VS Code, or in IntelliJ. Once the project is opened, the Maven build tool will allow you to run the app.
To do this, you will need to open IntelliJ, and open the Maven tab on the right of the screen marked as "m" then click the folder icon with a circular arrow that pulls up the tab "Generate Sources and Update Folders for All Projects", then click the icon to the immediate right of that called "Download Sources and/or Documentation."
After this, you can click the drop-down labeled "m csfirststeps/Plugins/spring-boot/spring-boot:run"
This will start a browser tab with the project in development mode that is what the intended final deployed project would look like. It functions fully as it would in deployment, it just is not hosted on a web server, but locally on your port: 8080
If time allowed, the project would have been deployed on AWS Elastic Beanstalk.
