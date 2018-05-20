#pragma comment(lib, "C:/Users/Osechkin/Downloads/google/googletest-release-1.8.0/googletest/msvc/gtest-md/Release/gtest.lib") 
#pragma comment(lib, "C:/Users/Osechkin/Downloads/google/googletest-release-1.8.0/googletest/msvc/gtest-md/Release/gtest_main-md.lib") 
#include <gtest/gtest.h>
#include <iostream>

using namespace std;

TEST(SquareRootTest, ZeroAndNegativeNos) {
	ASSERT_EQ(0.0, 0);
}

TEST(SquareRoot, ZeroAndNegativeNos) {
	ASSERT_EQ(1, 1);
}

void main(int argc, char **argv) {
	testing::InitGoogleTest(&argc, argv);
	RUN_ALL_TESTS();
	cout << 0;
}