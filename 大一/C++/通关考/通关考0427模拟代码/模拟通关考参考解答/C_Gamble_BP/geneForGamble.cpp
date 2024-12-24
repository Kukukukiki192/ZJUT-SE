//===========================
// gene for gamble
//===========================
#include<fstream>
using namespace std;
//---------------------------
int main(){
  ofstream cout("in.txt");
  cout<<"10 b 8\n20 b 6\n40 b 7\n80 b 9\n160 b 10\n320 b 5\n640 b 13\n";
  for(int i=1; i<=500; i++)
    cout<<random(999990)+1<<" "
        <<(random(100)>=50? 'b':'s')<<" "
        <<random(16)+3<<"\n";
}//--------------------------
     
 