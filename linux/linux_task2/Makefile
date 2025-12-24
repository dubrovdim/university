CXX      := g++
AR       := ar
CXXFLAGS := -std=c++17 -O2 -Wall -Wextra -Icalculator
BUILD    := build
OBJDIR   := $(BUILD)/obj
LIBDIR   := $(BUILD)/lib
BINDIR   := $(BUILD)/bin

CALC_DIR := calculator

LIB := $(LIBDIR)/libcalc.a
BIN := $(BINDIR)/app

OBJS := $(OBJDIR)/calculator.o $(OBJDIR)/main.o

.PHONY: all clean dirs
all: $(LIB) $(BIN)

dirs:
	@mkdir -p $(OBJDIR) $(LIBDIR) $(BINDIR)

$(OBJDIR)/calculator.o: $(CALC_DIR)/calculator.cpp | dirs
	$(CXX) $(CXXFLAGS) -c $< -o $@

$(OBJDIR)/main.o: src/main.cpp | dirs
	$(CXX) $(CXXFLAGS) -c $< -o $@

$(LIB): $(OBJDIR)/calculator.o | dirs
	$(AR) rcs $@ $^

$(BIN): $(OBJDIR)/main.o $(LIB) | dirs
	$(CXX) $^ -o $@

clean:
	rm -rf $(BUILD)
