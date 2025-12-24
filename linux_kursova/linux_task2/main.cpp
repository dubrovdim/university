#include "calculator.h"
#include <iostream>

int main() {
    Calculator c;
    std::cout << "2 + 3 = " << c.Add(2, 3) << "\n";
    std::cout << "7 - 4 = " << c.Sub(7, 4) << "\n";
    return 0;
}