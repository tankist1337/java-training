import os
import shutil

# Get the current directory
directory = os.getcwd()

# Get all the files in the directory
files = os.listdir(directory)

# Loop through each file
for file in files:
    # Create a repository with the same name as the file
    # os.makedirs(file)
    if file == "moveFiles.py" or file == ".vscode":
        continue

    dirname = file.replace(".java", "")

    if os.path.isdir(dirname) == False:
        # Create the directory
        os.makedirs(dirname)
        # Print success message
        print("The directory is created.")
        # Move the file into the repository
        shutil.move(file, dirname)
        print("The file is moved.")
    else:
        # Print the message if the directory exists
        print("The directory already exists.")
