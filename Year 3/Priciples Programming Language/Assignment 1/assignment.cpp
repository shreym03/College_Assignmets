#include <iostream>
#include <string>
#include <string.h>
#include <stdio.h>
#include <fstream>

using namespace std;

class Balance {
public:
	int salary[50], fees_paid[50];
	int i;
};

class Courses {
public:
	string id[50], name[50], course_tech[50], c1[50], c2[50], c3[50];
};

class Employee : public Balance, public Courses {
public:
	void getData(char eName[]) {
		string eid, ename;
		int sal;
		ifstream fhandel(eName);
		i = 0;

		while (fhandel >> eid >> ename >> sal) {
			id[i] = eid;
			name[i] = ename;
			salary[i] = sal; // cout << name[i] << "is the id added" << endl;
			i += 1;
		}
	}

	void listData() {
		for (int k = 0;k < i;k += 1)
			cout << " " << id[k] << " " << salary[k] << endl;
	}

	void putData(char eName[]) {
		ofstream nfhandel(eName);

		for (int k = 0;k < i;k++)
			nfhandel << " " << id[k] << " " << salary[k] << endl;
	}
};

class Instructor : public Balance, public Courses {
public:
	void getData(char iName[]) {
		string iid, courset;
		ifstream fhandel(iName);
		i = 0;

		while (fhandel >> iid >> courset) {
			id[i] = iid;
			course_tech[i] = courset; // cout << id[i] << "is the id added" << endl;
			i += 1;
		}
	}

	void listData() {
		for (int k = 0;k < i;k += 1)
			cout << " " << id[k] << " " << course_tech[k] << endl;
	}

	void putData(char iName[]) {
		ofstream nfhandel(iName);

		for (int k = 0;k < i;k++)
			nfhandel << " " << id[k] << " " << course_tech[k] << endl;
	}
};

class Student : public Balance, public Courses {
public:
	void getData(char sName[]) {
		string iid, nam, cour1, cour2, cour3;
		int fee;
		ifstream fhandel(sName);
		i = 0;

		while (fhandel >> iid >> nam >> fee >> cour1 >> cour2 >> cour3) {
			id[i] = iid;
			name[i] = nam;
			fees_paid[i] = fee;
			c1[i] = cour1;
			c2[i] = cour2;
			c3[i] = cour3; // cout << id[i] << "is the id added" << endl;
			i += 1;
		}
	}

	void listData() {
		for (int k = 0;k < i;k += 1)
			cout << id[k] << " " << name[k] << " " << fees_paid[k] << " " << c1[k] << " " << c2[k] << " " << " " << c3[k] << endl;
	}

	void putData(char sName[]) {
		ofstream nfhandel;

		nfhandel.open(sName, ios_base::app);
		for (int k = 0;k < i;k++)
			nfhandel << id[k] << " " << name[k] << " " << fees_paid[k] << " " << c1[k] << " " << c2[k] << " " << " " << c3[k] << endl;
	}
};
int main(int argc, char* argv[]) {
	char f_employee[20];
	char f_instructor[20];
	char f_student[20];
	char f_out[20];

	cout << "Enter the name of the Employee file: " << endl;
	cin >> f_employee;

	cout << "Enter the name of the Instructor file: " << endl;
	cin >> f_instructor;

	cout << "Enter the name of the Student file: " << endl;
	cin >> f_student;

	cout << "Enter the name of the Output file: " << endl;
	cin >> f_out;

	ofstream nfhandel;
	nfhandel.open(f_out, ios_base::app);

	nfhandel << "-----Question 1-----" << endl;
	cout << "-----Question 1-----" << endl;
	cout << "Employee details" << endl;
	Employee e;
	e.getData(f_employee);
	e.putData(f_out);
	e.listData();

	Instructor ins;
	Student s;
	ins.getData(f_instructor);
	s.getData(f_student);

	nfhandel << "-----Question 2-----" << endl;
	cout << "-----Question 2-----" << endl;
	cout << "Students who teach courses" << endl;
	for (int i = 0;i < s.i;i += 1) {
		for (int k = 0;k < e.i;k += 1) {
			for (int j = 0;j < ins.i;j += 1) {
				if (s.id[i] == e.id[k]) {
					if (ins.id[j] == e.id[k]) {
						nfhandel << " " << s.id[i] << " " << s.name[i] << " " << ins.course_tech[j] << " " << endl;
						cout << " " << s.id[i] << " " << s.name[i] << " " << ins.course_tech[j] << " " << endl;
					}
				}
			}
		}
	}

	nfhandel << "-----Question 3-----" << endl;
	cout << "-----Question 3-----" << endl;
	cout << "Students who don't teach courses" << endl;
	int flag;
	for (int i = 0;i < s.i;i += 1) {
		flag = 0;
		for (int j = 0;j < e.i;j += 1) {
			if (s.id[i] == e.id[j]) {
				flag = 1;
			}
		}
		if (flag == 0) {
			nfhandel << s.id[i] << " " << s.name[i] << endl;
			cout << s.id[i] << " " << s.name[i] << endl;
		}
	}

	nfhandel << "-----Question 4-----" << endl;
	cout << "-----Question 4-----" << endl;
	cout << "All Student details" << endl;
	s.listData();
	s.putData(f_out);//Question 4
	return 0;
}
