__author__ = 'Kaiyuan_Wang'

import sys

def main(src, dst):
    jacoco = open(src)
    src_string = ''
    for line in jacoco:
        src_string += line
    jacoco.close()
    pom = open(dst, 'r')
    dst_string = ''
    for line in pom:
        if '</project>' in line:
            dst_string += src_string + '\n' + line
            break
        dst_string += line
    pom = open(dst, 'r+')
    pom.write(dst_string)
    pom.truncate()
    pom.close()

if __name__ == '__main__':
    if not len(sys.argv) == 3:
        print 'Usage: python jacoco.py src dst'
    src = sys.argv[1]
    dst = sys.argv[2]
    main(src, dst)