# ImageConverter README

The **ImageConverter** is a simple Java program that allows you to read an image file, convert it to a different format, and display it in a JFrame. This program serves as a useful tool for image conversion and visualization.

## Table of Contents

- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Usage](#usage)
- [Features](#features)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The **ImageConverter** program is designed to provide a straightforward way to perform image conversion tasks in Java. It allows users to input a Windows file path, read an image, save it in a different format, and open the converted image in a graphical user interface (GUI).

## Prerequisites

Before using the **ImageConverter** program, ensure that you have the following prerequisites installed on your system:

- **Java**: You must have Java installed on your system. You can download it from [Java's official website](https://www.oracle.com/java/technologies/javase-downloads.html).

## Usage

To use the **ImageConverter** program:

1. Run the program by executing the `main` method in the `ImageConverter` class.

2. The program will prompt you to provide a Windows file path for the image you wish to convert. Make sure to include double quotes around the file path if it contains spaces.

3. After providing the input file path, the program will read the image, ask for an output location, and the desired image format for conversion.

4. The program will then convert the image to the specified format and save it in the output location.

5. Finally, it will open the converted image in a JFrame for display.

## Features

### 1. Image Reading

The program can read image files in various formats, thanks to the `readFile` method. It uses the `ImageIO` class to load the image data into a `BufferedImage`.

### 2. Image Conversion

You can specify the output location and the desired image format for the conversion using the program. The `writeFile` method saves the image in the chosen format.

### 3. Displaying the Image

The program can display the converted image in a graphical user interface (GUI) using a JFrame. The `openFile` method takes care of creating the GUI and displaying the image.

### 4. Quotation Mark Handling

The program includes a `stripQuotations` method to remove quotation marks from the provided file paths, ensuring compatibility with the `ImageIO` class.

## Contributing

Contributions to this project are welcome. If you'd like to contribute, please follow these steps:

1. Fork the repository.

2. Create a new branch for your feature or bug fix.

3. Make your changes and test them thoroughly.

4. Commit your changes with descriptive commit messages.

5. Create a pull request to merge your branch into the main repository.

Please ensure that your code adheres to the project's coding standards and that your changes are well-documented.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.