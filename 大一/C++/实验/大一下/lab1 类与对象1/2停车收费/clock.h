class clock
{
public:
long normalize()const;
void show_time();
void set_time();
double diff(const clock& T);
private:
int hour;
int minute;
int second;
};