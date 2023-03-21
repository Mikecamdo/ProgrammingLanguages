import re
def text_match(text):
    patterns = r'ab\w+'
    if re.search(patterns, text):
        return (patterns, text, 'Found a match!')
    else:
        return (patterns, text, 'Not matched!')

print("Text1:", text_match("Cats are smarter than dogs"))
print("Text2:", text_match("abc"))

# The following is the code to modify.
# Open file (please download the sample input file from Canvas.)
f = open('test1.txt', 'r')
data=f.read()
strings = re.findall("mask.", data)
#case sensitive
print ("Search1: mask or masks", strings)
strings = re.findall(r'\bfor\w*', data)
print ("Search2: words start with 'for': ", strings)
strings = re.findall(r'\w*ies\b', data)
print ("Search3: words end with 'ies': ", strings)
strings = re.findall(r'\bi\w*t\b', data)
print ("Search4: words begin with 'i' and end with 't': ", strings)