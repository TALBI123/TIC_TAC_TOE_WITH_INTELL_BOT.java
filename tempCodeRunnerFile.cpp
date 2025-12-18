#include <iostream>
using namespace std;
class Test{
    Test(){
        cout << "Test Constructeur!" << endl;
    }
    int x = 9;
};
void fun(Test obj){
    // cout << o ;
}
int main() {
    Test test;
    cout << "Hello, World!" << endl;
    return 0;
}