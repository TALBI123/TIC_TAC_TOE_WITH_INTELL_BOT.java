#include <iostream>
using namespace std;
class Test
{
public:
    int x = 9;
    Test()
    {
        cout << "Test Constructeur!" << endl;
    }
};

void fun(Test &obj)
{
    obj = Test();
}
int main()
{
    Test newObj;
    newObj.x = 990;
    fun(newObj);
    cout << newObj.x << endl;
    cout << "Hello, World!" << endl;
    return 0;
}