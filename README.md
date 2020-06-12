#### Transports
#### Usage
The program can be customized by changing the configuration file:
######  /src/main/resources/application.yml


Set the active profile, using the property `spring.profiles.active`<br />
Accepted values:<br />
- 'aws' - for loading the input file from S3<br/>
- 'fs' - for loading the input file from the File System

```spring.profiles.active: 'aws'```

<br/> If File System profile is selected, set the input directory path using `fs.path`. By default, the 'working_folder'(located in the project root) is used for read the input fle and write the output file. When setting a different directory, please do not include the slash separator at the end of the path.

```fs.path: 'working_directory'```

<br/>Property `filename` used for input file name. If the file used for running the program has an extension, please specify it: (i.e. file_data.json)

```filename: 'file_data'```

<br/>Property `aws.bucket` for specifying the S3 bucket name:

```aws.bucket: 'bucket-name'```

<br/>Output directory property (please do not include the slash separator at the end of the path)
```output.directory: 'working_directory'```

