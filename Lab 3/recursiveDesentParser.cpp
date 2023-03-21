#include <iostream>

using namespace std;

char input[50];
int inputCounter = 0;

int expression();
int term();
int factor();

int main() {
    //input strings
    //x = "2*3+4*5"; //test 1 - before change
    //x = "k2*3+4*5";        //test 2 - for error message
    //x = "8/2-1*3";         //test 3 - for / and -
    //x = "8/(4-2)";         //test 4 - for ()
    //x = "8*(4-2)+7";       //test 5 - for checking whole logic

    cout << "Part C test5:" << endl;
    cout << "Please enter a math expression." << endl;
    cin.getline(input, 50);
    cout << "The input expression : " << input << endl;
    int result = expression();
    cout << "**Parsing successful!" << endl;
    cout << "result = " << result << endl;
}

int expression() {
    cout << "Enter Expression : digit is " << *(input + inputCounter) << endl;
    int product1 = term();
    while (*(input + inputCounter) == '+') {
        inputCounter++;
        int product2 = term();
        cout << "product1 + product2 : " << product1 << " + " << product2 << " = " << product1 + product2 << endl;
        product1 = product1 + product2;
    } while (*(input + inputCounter) == '-') {
        inputCounter++;
        int product2 = term();
        cout << "product1 - product2 : " << product1 << " - " << product2 << " = " << product1 - product2 << endl;
        product1 = product1 - product2;
    }

    return product1;
}

int term() {
    cout << "Enter Term : digit is " << *(input + inputCounter) << endl;
    int factor1 = factor();
    while (*(input + inputCounter) == '*') {
        inputCounter++;
        int factor2 = factor();
        cout << "factor1 * factor2 : " << factor1 << " * " << factor2 << " = " << factor1 * factor2 << endl;
        factor1 = factor1 * factor2;
    } while (*(input + inputCounter) == '/') {
        inputCounter++;
        int factor2 = factor();
        cout << "factor1 / factor2 : " << factor1 << " / " << factor2 << " = " << factor1 / factor2 << endl;
        factor1 = factor1 / factor2;
    }

    return factor1;
}

int factor() {
    if (*(input + inputCounter) == '(') {
        inputCounter++;
        int y = expression();
        if (*(input + inputCounter) == ')') {
            inputCounter++;
        }
        return y;
    }

    cout << "Enter Factor: digit is " << *(input + inputCounter) << endl;
    if (*(input + inputCounter) >= '0' && *(input + inputCounter) <= '9')
    {
        int y = *(input + inputCounter) - '0';
        inputCounter++; //advance to next character.
        return y;
    }
    else {
        cout << "Error: Invalid digit found: " << *(input + inputCounter) << endl;
        exit(1);
    }
}